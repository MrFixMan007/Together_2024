package com.example.together.database

import android.util.Log
import com.example.database.MyDatabase
import com.example.database.entity.NoteEntity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class LocalNoteTest{
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var database: MyDatabase

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun testSaveLocalNote() = runTest {
        val noteEntity = NoteEntity(
            title = "test title",
            description = "test description",
        )
        val noteDao = database.noteDao()
        noteDao.save(noteEntity)
        val response = noteDao.getLastNote()
        Log.e("response", response.toString())
        assertNotNull(response)
    }
}
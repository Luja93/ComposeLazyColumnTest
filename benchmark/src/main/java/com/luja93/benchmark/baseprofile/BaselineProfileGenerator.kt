package com.luja93.benchmark.baseprofile

import androidx.benchmark.macro.ExperimentalBaselineProfilesApi
import androidx.benchmark.macro.junit4.BaselineProfileRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Generates a baseline profile which can be copied to `app/src/main/baseline-prof.txt`.
 */
@ExperimentalBaselineProfilesApi
@RunWith(AndroidJUnit4::class)
class BaselineProfileGenerator {
    @get:Rule
    val baselineProfileRule = BaselineProfileRule()

    @Test
    fun startup() = baselineProfileRule.collectBaselineProfile(
        packageName = "com.luja93.composelazycolumntest",
    ) {
        pressHome()

        startActivityAndWait()
        device.waitForIdle()

        device.run {
            findObject(By.text("Coach"))
            waitForIdle()

            val column = findObject(By.res("squadLazyColumn"))
            // Set gesture margin to avoid triggering gesture navigation
            // with input events from automation.
            column.setGestureMargin(displayWidth / 5)

            // Scroll down and up and up several times
            column.fling(Direction.DOWN)
            waitForIdle()
            column.fling(Direction.UP)
            waitForIdle()
            column.fling(Direction.DOWN)
            waitForIdle()
            column.fling(Direction.UP)
            waitForIdle()
            column.fling(Direction.DOWN)
            waitForIdle()
            column.fling(Direction.UP)
            waitForIdle()
            column.fling(Direction.DOWN)
            waitForIdle()
            column.fling(Direction.UP)
            waitForIdle()
            column.fling(Direction.DOWN)
            waitForIdle()
            column.fling(Direction.UP)
            waitForIdle()
            column.fling(Direction.DOWN)
            waitForIdle()
            column.fling(Direction.UP)
            waitForIdle()

            findObject(By.text("Coach"))
            waitForIdle()
        }
    }
}

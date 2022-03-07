package br.com.marquesapps.editoras.ui.activities

import android.widget.EditText
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import br.com.marquesapps.editoras.R
import org.hamcrest.CoreMatchers.allOf
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class EditorasActivityTest {


    @Before
    fun setUp() {
        ActivityScenario.launch(EditorasActivity::class.java)
    }

    @Test
    fun deve_FazerOFluxoAteOLivro_QuandoInserirISBN() {
        onView(withId(R.id.fab_busca_activity_editoras))
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.info_busca_isbn_item))
            .check(matches(isDisplayed()))

        onView(
            allOf(
                isDescendantOfA(withId(R.id.isbn_campo_busca_isbn_item)),
                isAssignableFrom(EditText::class.java)
            )
        )
            .check(matches(isDisplayed()))
            .perform(click())
            .perform(typeText("9788521213284"))

        onView(withId(android.R.id.button1))
            .perform(click())

        Thread.sleep(3000)

        onView(
            withText("Design de superfície")
        ).check(matches(isDisplayed()))
    }

    @Test
    fun deve_FazerOFluxoAteEditora_QuandoTocarSobreAPrimeira() {
        Thread.sleep(1500)

        onView(withText("Ignis"))
            .check(matches(isDisplayed()))
            .perform(click())

        Thread.sleep(1500)

        onView(
            withText("31.345.972/0001-41")
        ).check(matches(isDisplayed()))
    }

}
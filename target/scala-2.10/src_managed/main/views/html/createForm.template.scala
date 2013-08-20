
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object createForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Computer],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(computerForm: Form[Computer]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.f) }};
Seq[Any](format.raw/*1.32*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.75*/(""" 

"""),_display_(Seq[Any](/*7.2*/main/*7.6*/ {_display_(Seq[Any](format.raw/*7.8*/("""
    
    <h1>Dodaj ksiazke</h1>
    
    """),_display_(Seq[Any](/*11.6*/form(routes.Application.save())/*11.37*/ {_display_(Seq[Any](format.raw/*11.39*/("""
        
        <fieldset>
        
            """),_display_(Seq[Any](/*15.14*/inputText(computerForm("tytul"), '_label -> "Tytuł"))),format.raw/*15.66*/("""
            """),_display_(Seq[Any](/*16.14*/inputText(computerForm("autor"), '_label -> "Autor"))),format.raw/*16.66*/("""
            """),_display_(Seq[Any](/*17.14*/inputText(computerForm("data"), '_label -> "data"))),format.raw/*17.64*/("""
            """),_display_(Seq[Any](/*18.14*/inputText(computerForm("opinia"), '_label -> "Opinia"))),format.raw/*18.68*/("""
            """),_display_(Seq[Any](/*19.14*/inputText(computerForm("ocena"), '_label -> "Ocena"))),format.raw/*19.66*/("""
            """),_display_(Seq[Any](/*20.14*/inputText(computerForm("stron"), '_label -> "Stron"))),format.raw/*20.66*/("""   

        </fieldset>
        
        <div class="actions">
            <input type="submit" value="Dodaj ta książke" class="btn primary"> albo
            <a href=""""),_display_(Seq[Any](/*26.23*/routes/*26.29*/.Application.list())),format.raw/*26.48*/("""" class="btn">Zrezygnuj</a> 
        </div>
        
    """)))})),format.raw/*29.6*/("""
    
""")))})),format.raw/*31.2*/("""
"""))}
    }
    
    def render(computerForm:Form[Computer]): play.api.templates.Html = apply(computerForm)
    
    def f:((Form[Computer]) => play.api.templates.Html) = (computerForm) => apply(computerForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Aug 20 09:11:11 CEST 2013
                    SOURCE: /opt/play-2.1.3/samples/scala/computer-database/app/views/createForm.scala.html
                    HASH: 6e436635125437030af8cd216133c7b9ca0951f0
                    MATRIX: 518->1|633->52|665->76|744->31|772->50|800->125|838->129|849->133|887->135|965->178|1005->209|1045->211|1132->262|1206->314|1256->328|1330->380|1380->394|1452->444|1502->458|1578->512|1628->526|1702->578|1752->592|1826->644|2032->814|2047->820|2088->839|2177->897|2215->904
                    LINES: 19->1|22->5|22->5|23->1|25->4|26->5|28->7|28->7|28->7|32->11|32->11|32->11|36->15|36->15|37->16|37->16|38->17|38->17|39->18|39->18|40->19|40->19|41->20|41->20|47->26|47->26|47->26|50->29|52->31
                    -- GENERATED --
                */
            
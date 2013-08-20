
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
object editForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Long,Form[Computer],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(id: Long, computerForm: Form[Computer]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.f) }};
Seq[Any](format.raw/*1.42*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.75*/("""

"""),_display_(Seq[Any](/*7.2*/main/*7.6*/ {_display_(Seq[Any](format.raw/*7.8*/("""
    
    <h1>Edit computer</h1>
    
    """),_display_(Seq[Any](/*11.6*/form(routes.Application.update(id))/*11.41*/ {_display_(Seq[Any](format.raw/*11.43*/("""
        
        <fieldset>
        
            """),_display_(Seq[Any](/*15.14*/inputText(computerForm("tytul"), '_label -> "Tytuł"))),format.raw/*15.66*/("""
            """),_display_(Seq[Any](/*16.14*/inputText(computerForm("autor"), '_label -> "Autor"))),format.raw/*16.66*/("""
            """),_display_(Seq[Any](/*17.14*/inputText(computerForm("data"), '_label -> "data"))),format.raw/*17.64*/("""
            """),_display_(Seq[Any](/*18.14*/inputText(computerForm("opinia"), '_label -> "Opinia"))),format.raw/*18.68*/("""
            """),_display_(Seq[Any](/*19.14*/inputText(computerForm("ocena"), '_label -> "Ocena"))),format.raw/*19.66*/("""
            """),_display_(Seq[Any](/*20.14*/inputText(computerForm("stron"), '_label -> "Stron"))),format.raw/*20.66*/("""
        </fieldset>
        
        <div class="actions">
            <input type="submit" value="Save this computer" class="btn primary"> or 
            <a href=""""),_display_(Seq[Any](/*25.23*/routes/*25.29*/.Application.list())),format.raw/*25.48*/("""" class="btn">Cancel</a> 
        </div>
        
    """)))})),format.raw/*28.6*/("""
    
    """),_display_(Seq[Any](/*30.6*/form(routes.Application.delete(id), 'class -> "topRight")/*30.63*/ {_display_(Seq[Any](format.raw/*30.65*/("""
        <input type="submit" value="Delete this computer" class="btn danger">
    """)))})),format.raw/*32.6*/("""
    
""")))})),format.raw/*34.2*/("""
"""))}
    }
    
    def render(id:Long,computerForm:Form[Computer]): play.api.templates.Html = apply(id,computerForm)
    
    def f:((Long,Form[Computer]) => play.api.templates.Html) = (id,computerForm) => apply(id,computerForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Aug 20 09:18:16 CEST 2013
                    SOURCE: /opt/play-2.1.3/samples/scala/computer-database/app/views/editForm.scala.html
                    HASH: c6b56f110b240247da881e4c53a7f0726bf52fc6
                    MATRIX: 521->1|646->62|678->86|757->41|785->60|813->135|850->138|861->142|899->144|977->187|1021->222|1061->224|1148->275|1222->327|1272->341|1346->393|1396->407|1468->457|1518->471|1594->525|1644->539|1718->591|1768->605|1842->657|2045->824|2060->830|2101->849|2187->904|2233->915|2299->972|2339->974|2454->1058|2492->1065
                    LINES: 19->1|22->5|22->5|23->1|25->4|26->5|28->7|28->7|28->7|32->11|32->11|32->11|36->15|36->15|37->16|37->16|38->17|38->17|39->18|39->18|40->19|40->19|41->20|41->20|46->25|46->25|46->25|49->28|51->30|51->30|51->30|53->32|55->34
                    -- GENERATED --
                */
            
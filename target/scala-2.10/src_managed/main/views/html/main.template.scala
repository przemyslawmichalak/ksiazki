
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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.17*/("""

<!DOCTYPE html>
<html>
    <head>
        <title>Baza książek</title>
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*7.70*/routes/*7.76*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*7.119*/(""""> 
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*8.70*/routes/*8.76*/.Assets.at("stylesheets/main.css"))),format.raw/*8.110*/(""""> 
    </head>
    <body>
        
        <header class="topbar">
            <h1 class="fill">
                <a href=""""),_display_(Seq[Any](/*14.27*/routes/*14.33*/.Application.index())),format.raw/*14.53*/("""">
                   &mdash; Baza książek
                </a>
            </h1>
        </header>
        
        <section id="main">
            """),_display_(Seq[Any](/*21.14*/content)),format.raw/*21.21*/("""
        </section>
        
    </body>
</html>
"""))}
    }
    
    def render(content:Html): play.api.templates.Html = apply(content)
    
    def f:((Html) => play.api.templates.Html) = (content) => apply(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Aug 20 09:18:16 CEST 2013
                    SOURCE: /opt/play-2.1.3/samples/scala/computer-database/app/views/main.scala.html
                    HASH: 710bc64e2f1b641a52915001e3594866c1060361
                    MATRIX: 502->1|594->16|770->157|784->163|849->206|957->279|971->285|1027->319|1187->443|1202->449|1244->469|1430->619|1459->626
                    LINES: 19->1|22->1|28->7|28->7|28->7|29->8|29->8|29->8|35->14|35->14|35->14|42->21|42->21
                    -- GENERATED --
                */
            
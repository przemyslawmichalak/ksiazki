
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
object list extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Page[Computer],Int,String,play.api.mvc.Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(currentPage: Page[(Computer)], currentOrderBy: Int, currentFilter: String)(implicit flash: play.api.mvc.Flash):play.api.templates.Html = {
        _display_ {
def /*16.2*/header/*16.8*/(orderBy: Int, title: String):play.api.templates.Html = {_display_(

Seq[Any](format.raw/*16.41*/("""
    <th class="col"""),_display_(Seq[Any](/*17.20*/orderBy)),format.raw/*17.27*/(""" header """),_display_(Seq[Any](/*17.36*/if(scala.math.abs(currentOrderBy) == orderBy){/*17.83*/{if(currentOrderBy < 0) "headerSortDown" else "headerSortUp"}})),format.raw/*17.144*/("""">
        <a href=""""),_display_(Seq[Any](/*18.19*/link(0, Some(orderBy)))),format.raw/*18.41*/("""">"""),_display_(Seq[Any](/*18.44*/title)),format.raw/*18.49*/("""</a>
    </th>
""")))};def /*6.2*/link/*6.6*/(newPage: Int, newOrderBy: Option[Int] = None) = {{
    routes.Application.list(newPage, newOrderBy.map { orderBy =>
        if(orderBy == scala.math.abs(currentOrderBy)) -currentOrderBy else orderBy
    }.getOrElse(currentOrderBy), currentFilter)
    
}};
Seq[Any](format.raw/*1.113*/("""

"""),format.raw/*5.42*/("""
"""),format.raw/*11.2*/("""

"""),format.raw/*15.37*/("""
"""),format.raw/*20.2*/("""

"""),_display_(Seq[Any](/*22.2*/main/*22.6*/ {_display_(Seq[Any](format.raw/*22.8*/("""
    
    <h1>Znaleziono """),_display_(Seq[Any](/*24.21*/currentPage/*24.32*/.total)),format.raw/*24.38*/(""" książki</h1>

    """),_display_(Seq[Any](/*26.6*/flash/*26.11*/.get("success").map/*26.30*/ { message =>_display_(Seq[Any](format.raw/*26.43*/("""
        <div class="alert-message warning">
            <strong>Skonczone!</strong> """),_display_(Seq[Any](/*28.42*/message)),format.raw/*28.49*/("""
        </div>
    """)))})),format.raw/*30.6*/("""

    <div id="actions">
        
        """),_display_(Seq[Any](/*34.10*/helper/*34.16*/.form(action=routes.Application.list())/*34.55*/ {_display_(Seq[Any](format.raw/*34.57*/("""
            <input type="search" id="searchbox" name="f" value=""""),_display_(Seq[Any](/*35.66*/currentFilter)),format.raw/*35.79*/("""" placeholder="Sortuj po tytule...">
            <input type="submit" id="searchsubmit" value="Sortuj po tytule" class="btn primary">
        """)))})),format.raw/*37.10*/("""
        
        <a class="btn success" id="add" href=""""),_display_(Seq[Any](/*39.48*/routes/*39.54*/.Application.create())),format.raw/*39.75*/("""">Dodaj ksiazke</a>
        
    </div>
    
    """),_display_(Seq[Any](/*43.6*/Option(currentPage.items)/*43.31*/.filterNot(_.isEmpty).map/*43.56*/ { computers =>_display_(Seq[Any](format.raw/*43.71*/("""
        
        <table class="computers zebra-striped">
            <thead>
                <tr>
                    """),_display_(Seq[Any](/*48.22*/header(2, "Tytul"))),format.raw/*48.40*/("""
                    """),_display_(Seq[Any](/*49.22*/header(3, "Autor"))),format.raw/*49.40*/("""
                    """),_display_(Seq[Any](/*50.22*/header(4, "Data"))),format.raw/*50.39*/("""
                    """),_display_(Seq[Any](/*51.22*/header(5, "Opinia"))),format.raw/*51.41*/("""
                    """),_display_(Seq[Any](/*52.22*/header(6, "Ocena"))),format.raw/*52.40*/("""
                    """),_display_(Seq[Any](/*53.22*/header(7, "Stron"))),format.raw/*53.40*/("""
                </tr>
            </thead>
            <tbody>

                """),_display_(Seq[Any](/*58.18*/computers/*58.27*/.map/*58.31*/ {/*59.21*/case (computer) =>/*59.39*/ {_display_(Seq[Any](format.raw/*59.41*/("""
                        <tr>
                            <td><a href=""""),_display_(Seq[Any](/*61.43*/routes/*61.49*/.Application.edit(computer.id.get))),format.raw/*61.83*/("""">"""),_display_(Seq[Any](/*61.86*/computer/*61.94*/.tytul)),format.raw/*61.100*/("""</a></td>
                            <td>
                                """),_display_(Seq[Any](/*63.34*/computer/*63.42*/.autor)),format.raw/*63.48*/("""
                            </td>
                            <td>
                                """),_display_(Seq[Any](/*66.34*/computer/*66.42*/.data.map(_.format("dd MMM yyyy")).getOrElse/*66.86*/ {_display_(Seq[Any](format.raw/*66.88*/(""" <em>-</em> """)))})),format.raw/*66.101*/("""
                            </td>
                            <td>
                                """),_display_(Seq[Any](/*69.34*/computer/*69.42*/.opinia)),format.raw/*69.49*/("""
                            </td>
                            <td>
                                """),_display_(Seq[Any](/*72.34*/computer/*72.42*/.ocena)),format.raw/*72.48*/("""
                            </td>
                            <td>
                                """),_display_(Seq[Any](/*75.34*/computer/*75.42*/.stron)),format.raw/*75.48*/("""
                            </td>                                                     
                        </tr>
                    """)))}})),format.raw/*79.18*/("""

            </tbody>
        </table>

        <div id="pagination" class="pagination">
            <ul>
                """),_display_(Seq[Any](/*86.18*/currentPage/*86.29*/.prev.map/*86.38*/ { page =>_display_(Seq[Any](format.raw/*86.48*/("""
                    <li class="prev">
                        <a href=""""),_display_(Seq[Any](/*88.35*/link(page))),format.raw/*88.45*/("""">&larr; Poprzednia</a>
                    </li> 
                """)))}/*90.18*/.getOrElse/*90.28*/ {_display_(Seq[Any](format.raw/*90.30*/("""
                    <li class="prev disabled">
                        <a>&larr; Poprzednia</a>
                    </li>
                """)))})),format.raw/*94.18*/("""
                <li class="current">
                    <a>Displaying """),_display_(Seq[Any](/*96.36*/(currentPage.offset + 1))),format.raw/*96.60*/(""" z """),_display_(Seq[Any](/*96.64*/(currentPage.offset + computers.size))),format.raw/*96.101*/(""" na """),_display_(Seq[Any](/*96.106*/currentPage/*96.117*/.total)),format.raw/*96.123*/("""</a>
                </li>
                """),_display_(Seq[Any](/*98.18*/currentPage/*98.29*/.next.map/*98.38*/ { page =>_display_(Seq[Any](format.raw/*98.48*/("""
                    <li class="next">
                        <a href=""""),_display_(Seq[Any](/*100.35*/link(page))),format.raw/*100.45*/("""">Nastepna &rarr;</a>
                    </li> 
                """)))}/*102.18*/.getOrElse/*102.28*/ {_display_(Seq[Any](format.raw/*102.30*/("""
                    <li class="next disabled">
                        <a>Nastepna &rarr;</a>
                    </li>
                """)))})),format.raw/*106.18*/("""
            </ul>
        </div>
        
    """)))}/*110.6*/.getOrElse/*110.16*/ {_display_(Seq[Any](format.raw/*110.18*/("""
        
        <div class="well">
            <em>Nic tu nie ma</em>
        </div>
        
    """)))})),format.raw/*116.6*/("""

        
""")))})),format.raw/*119.2*/("""

            """))}
    }
    
    def render(currentPage:Page[Computer],currentOrderBy:Int,currentFilter:String,flash:play.api.mvc.Flash): play.api.templates.Html = apply(currentPage,currentOrderBy,currentFilter)(flash)
    
    def f:((Page[Computer],Int,String) => (play.api.mvc.Flash) => play.api.templates.Html) = (currentPage,currentOrderBy,currentFilter) => (flash) => apply(currentPage,currentOrderBy,currentFilter)(flash)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Aug 20 09:54:31 CEST 2013
                    SOURCE: /opt/play-2.1.3/samples/scala/computer-database/app/views/list.scala.html
                    HASH: 2c57d17e1b6306273de02eb1787838d181ad3481
                    MATRIX: 542->1|714->611|728->617|825->650|881->670|910->677|955->686|1010->733|1095->794|1152->815|1196->837|1235->840|1262->845|1300->241|1311->245|1596->112|1625->239|1653->499|1683->609|1711->861|1749->864|1761->868|1800->870|1862->896|1882->907|1910->913|1965->933|1979->938|2007->957|2058->970|2180->1056|2209->1063|2261->1084|2340->1127|2355->1133|2403->1172|2443->1174|2545->1240|2580->1253|2755->1396|2848->1453|2863->1459|2906->1480|2991->1530|3025->1555|3059->1580|3112->1595|3268->1715|3308->1733|3366->1755|3406->1773|3464->1795|3503->1812|3561->1834|3602->1853|3660->1875|3700->1893|3758->1915|3798->1933|3916->2015|3934->2024|3947->2028|3958->2052|3985->2070|4025->2072|4133->2144|4148->2150|4204->2184|4243->2187|4260->2195|4289->2201|4401->2277|4418->2285|4446->2291|4583->2392|4600->2400|4653->2444|4693->2446|4739->2459|4876->2560|4893->2568|4922->2575|5059->2676|5076->2684|5104->2690|5241->2791|5258->2799|5286->2805|5458->2962|5618->3086|5638->3097|5656->3106|5704->3116|5813->3189|5845->3199|5932->3267|5951->3277|5991->3279|6163->3419|6272->3492|6318->3516|6358->3520|6418->3557|6460->3562|6481->3573|6510->3579|6590->3623|6610->3634|6628->3643|6676->3653|6786->3726|6819->3736|6905->3802|6925->3812|6966->3814|7137->3952|7204->4000|7224->4010|7265->4012|7398->4113|7442->4125
                    LINES: 19->1|21->16|21->16|23->16|24->17|24->17|24->17|24->17|24->17|25->18|25->18|25->18|25->18|27->6|27->6|33->1|35->5|36->11|38->15|39->20|41->22|41->22|41->22|43->24|43->24|43->24|45->26|45->26|45->26|45->26|47->28|47->28|49->30|53->34|53->34|53->34|53->34|54->35|54->35|56->37|58->39|58->39|58->39|62->43|62->43|62->43|62->43|67->48|67->48|68->49|68->49|69->50|69->50|70->51|70->51|71->52|71->52|72->53|72->53|77->58|77->58|77->58|77->59|77->59|77->59|79->61|79->61|79->61|79->61|79->61|79->61|81->63|81->63|81->63|84->66|84->66|84->66|84->66|84->66|87->69|87->69|87->69|90->72|90->72|90->72|93->75|93->75|93->75|96->79|103->86|103->86|103->86|103->86|105->88|105->88|107->90|107->90|107->90|111->94|113->96|113->96|113->96|113->96|113->96|113->96|113->96|115->98|115->98|115->98|115->98|117->100|117->100|119->102|119->102|119->102|123->106|127->110|127->110|127->110|133->116|136->119
                    -- GENERATED --
                */
            
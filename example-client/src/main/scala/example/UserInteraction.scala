package example

import org.scalajs.dom
import org.scalajs.dom.document

import scala.scalajs.js.annotation.JSExport

@JSExport
object UserInteraction  {

  @JSExport
  def main() = Unit

  @JSExport
  def addParagraph(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }

}
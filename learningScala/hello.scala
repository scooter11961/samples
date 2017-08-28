def toMorseCode(text: String): String = {
 def recToMorseCode(text: String, accum: List[String]): List[String] = 
    text match {
        case '' => accum
        case letter :: rest if letter.toUpperCase == "A" => recToMorseCode(rest, ".-" :: accum)
        case letter :: rest if letter.toUpperCase == "B" => recToMorseCode(rest, "-.." :: accum)
        case letter :: rest if letter.toUpperCase == "C" => recToMorseCode(rest, "-.-." :: accum)
        case letter :: rest if letter.toUpperCase == "D" => recToMorseCode(rest, "-.." :: accum)
        case letter :: rest if letter.toUpperCase == "E" => recToMorseCode(rest, "." :: accum)
        case letter :: rest if letter.toUpperCase == " " => recToMorseCode(rest, " / " :: accum)
    }
 recToMorseCode(text, Nil).reverse.mkString
}

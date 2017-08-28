class Morse
@@cw = {'.-' => 'A','-...' => 'B','-.-.' => 'C','-..' => 'D','.' =>  
'E','..-.' => 'F','--.' => 'G',
        '....' => 'H','..' => 'I','.---' => 'J','-.-' => 'K','.-..' =>  
'L','--' => 'M','-.' => 'N',
        '---' => 'O','.--.' => 'P','--.-' => 'Q','.-.' => 'R','...' =>  
'S','-' => 'T','..-' => 'U',
        '...-' => 'V','.--' => 'W','-..-' => 'X','-.--' => 'Y','--..' => 'Z'}
def initialize(dotsanddashes) 
		
        parse(dotsanddashes,"")
end
def parse(dotsanddashes,letters)
        if dotsanddashes.size == 0 then
                        puts letters
                        return
        end
        @@cw.keys.each {|try|
                if /^#{try.gsub(/\./,'\.')}/.match(dotsanddashes) then
                        parse(dotsanddashes[$&.size,dotsanddashes.size],letters + @@cw[$&])
                end
        }
end #parse
end #Morse
Morse.new(STDIN.read.chomp) 

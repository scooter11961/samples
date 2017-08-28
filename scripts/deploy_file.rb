 require 'stringio'

 deployed_commit = '325c9dfebbeeb895c9b18634df15e18bb49bb56e'
 deploy_date = 'Today'
 current = "/data/mapquest/yogi/current"


   #str = StringIO.open do |str|
#   file = File.open("/data/mapquest/yogi/current/public/deploy.txt", "w") do |file|
   file = File.open("deploy.txt", "w") do |file|

    file.puts 'Date deployed is ' + deploy_date + ' Eastern Time Zone'
    file.puts 'Branch is ' + deployed_commit 
    file.puts `git show #{deployed_commit} | head -1`
    file.close
#    str.string
#    str.eof? # => true
   end

#    on roles(:all) do
#      contents = str
#      execute "mkdir #{current)}/public && touch #{current)}/public/deploy.txt"
#      upload! contents, "#{current)}/public/deploy.txt"
#    end
#  end

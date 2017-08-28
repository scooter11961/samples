Mypath=$HOME'/MobileWebAutomation/';
echo Setting up $Mypath as work area..
rm -rf $Mypath;
mkdir $Mypath;
cp -rf * $Mypath;
cd $Mypath;
echo Starting RC server in background
nohup ant startserver &


require kde4.inc
require kde4-native.inc
inherit native

SRC_URI = "svn://anonsvn.kde.org/home/kde/trunk/kdesupport;module=automoc;proto=svn"

S = "${WORKDIR}/automoc" 


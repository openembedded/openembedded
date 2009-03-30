require kde4.inc

DEPENDS += "automoc-native clucene-core"

PV = "2.1"
SRC_URI = "svn://anonsvn.kde.org/home/kde/branches/soprano;module=${PV};proto=svn"

S= "${WORKDIR}/${PV}"


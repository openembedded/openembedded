include ${PN}.inc

DEPENDS += "bluez-libs"
PV = "1.2.1+cvs-${CVSDATE}"

MODULES = "opiecore opiedb opiemm opienet opiepim opiesecurity opieui opiebluez"
LIBS    = "core2    db2    mm2    net2    pim2    security2    ui2    bluez2"

SRC_URI = "${HANDHELDS_CVS};module=opie/libopie2 \
           file://include.pro"

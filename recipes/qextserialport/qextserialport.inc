DESCRIPTION = "Serial Port Library for Qt"
SECTION = "libs"
PRIORITY = "optional"

PV = "0.0+${PR}+hg${SRCREV}"
PR = "r0"

SRCREV = "default"
SRC_URI = "hg://qextserialport.googlecode.com/hg;rev=${SRCREV};module=qextserialport;proto=https"

S = "${WORKDIR}/qextserialport"

do_install() {
	install -d ${D}${libdir} \
		   ${D}${includedir}
	oe_libinstall -so -C src/build libqextserialport ${D}${libdir}
	cp -pPR src/*.h ${D}${includedir}
}

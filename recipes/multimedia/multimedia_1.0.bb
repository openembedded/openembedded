DESCRIPTION = "MultiMedia files"
LICENSE = "GPL"
PR = "r5"

# This package allows you to add multimedia contents to the file system
# To add this, you define 
# MULTIMEDIA_FILES=<path><filename>.tar.bz2 in local.conf
# and include "multimedia" in your image

do_install() {
	install -d ${D}/usr/share/multimedia
	if [ "x${MULTIMEDIA_FILES}" != "x" ] ; then
		if [ -f ${MULTIMEDIA_FILES} ] ; then
			tar jxvf ${MULTIMEDIA_FILES}	-C ${D}/usr/share/multimedia
		fi
	fi
}

FILES_${PN} = "\
	/usr/share/multimedia/* \
	/usr/share/multimedia \
	"


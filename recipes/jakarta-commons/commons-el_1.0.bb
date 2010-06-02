require jakarta-commons.inc

DESCRIPTION = "Implementation of the JSP2.0 Expression Language API"

SRC_URI = "http://www.apache.org/dist/commons/el/source/${BP}-src.tar.gz"

DEPENDS += "jsp2.0 servlet2.4"
RDEPENDS_${PN} = "libjsp2.0-java libservlet2.4-java"

CP = "jsp-api-2.0 servlet-api-2.4"

FINDARGS = "\( -name '*.properties' -or -name '*.jj' \)"



SRC_URI[md5sum] = "25038283a0b5f638db5e891295d20020"
SRC_URI[sha256sum] = "3c9bdded6073563aaaddc9ad7c7387b242dc03cc385381503026b665a366c2c6"

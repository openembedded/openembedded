require jakarta-commons.inc

DESCRIPTION = "Implementation of the JSP2.0 Expression Language API"

SRC_URI = "http://www.apache.org/dist/commons/el/source/${BP}-src.tar.gz"

DEPENDS += "jsp2.0 servlet2.4"
RDEPENDS = "libjsp2.0-java libservlet2.4-java"

CP = "jsp-api-2.0 servlet-api-2.4"

FINDARGS = "\( -name '*.properties' -or -name '*.jj' \)"



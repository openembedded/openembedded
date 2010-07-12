require jakarta-commons.inc

DESCRIPTION = "Efficient, up-to-date, and feature-rich package implementing the client side of the most recent HTTP standards and recommendations"

SRC_URI = "http://www.apache.org/dist/httpcomponents/commons-httpclient/source/${BP}-src.tar.gz"

S = "${WORKDIR}/${BP}"

DEPENDS += "commons-logging commons-codec"
RDEPENDS = "libcommons-logging-java libcommons-codec-java"

CP = "commons-logging commons-codec"


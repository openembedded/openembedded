require navit.inc

PR = "${INC_PR}.0"

SRC_URI = "${SOURCEFORGE_MIRROR}/navit/navit-${PV}.tar.gz"

SRC_URI_append +=  "file://navit.xml-so.patch;patch=1"

SRC_URI[md5sum] = "c2ec1ddff62c2b248dbaeab1ab656d74"
SRC_URI[sha256sum] = "c069e983ea8bb9b6706d35126350d4d14619b9ce0ac888adbcdda3ff13362ab4"

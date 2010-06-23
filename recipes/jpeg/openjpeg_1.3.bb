DESCRIPTION = "Open-source JPEG 2000 codec written in C language"
HOMEPAGE = "http://www.openjpeg.org"
SECTION = "libs"
LICENSE = "BSD"
PR = "r0"
BBCLASSEXTEND = "native"

SRC_URI = "http://openjpeg.googlecode.com/files/openjpeg_v1_3.tar.gz \
           file://fix_installdir.patch"

S = "${WORKDIR}/OpenJPEG_v1_3"

inherit cmake

EXTRA_OECMAKE="-DBUILD_SHARED_LIBS:BOOL=ON"

PACKAGES =+ "openjpeg-tools "
FILES_openjpeg-tools = "${bindir}/*"

SRC_URI[md5sum] = "f9a3ccfa91ac34b589e9bf7577ce8ff9"
SRC_URI[sha256sum] = "3bca2e1e040f9dcbbcb1e0627f17a76eeb95e153bf663d082070c044a21202bd"

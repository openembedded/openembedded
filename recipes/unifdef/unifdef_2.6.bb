DESCRIPTION = "selectively remove C preprocessor conditionals"
HOMEPAGE = "http://dotat.at/prog/unifdef/"
# The sources are under the 2 clause BSD license, the man page is under
# the 3 clause BSD license.
LICENSE = "BSD"
PR = "0"

SRC_URI = "http://dotat.at/prog/unifdef/unifdef-${PV}.tar.gz"
SRC_URI[md5sum] = "18b832baea2c7b6b00bd7d4f3db38f62"
SRC_URI[sha256sum] = "e4cbc673d32ebe10e00bc00b985c974e327e65d4b32a564d21358e458079e419"


EXTRA_OEMAKE = "-e"

do_install () {
    oe_runmake 'man1dest=${D}${mandir}/man1' \
               'bindest=${D}${bindir}' \
               install
}

NATIVE_INSTALL_WORKS = "1"
BBCLASSEXTEND += "native nativesdk"

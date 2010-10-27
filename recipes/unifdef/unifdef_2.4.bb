DESCRIPTION = "selectively remove C preprocessor conditionals"
HOMEPAGE = "http://dotat.at/prog/unifdef/"
# The sources are under the 2 clause BSD license, the man page is under
# the 3 clause BSD license.
LICENSE = "BSD"
PR = "0"

SRC_URI = "http://dotat.at/prog/unifdef/unifdef-${PV}.tar.gz"
SRC_URI[md5sum] = "9aba8b30187244677f25834cbc11bfe2"
SRC_URI[sha256sum] = "52b8b5c411b3d33646b6a7518c37c3a2a308887c45ac58a13122823b02fd4f4a"

EXTRA_OEMAKE = "-e"

do_install () {
    oe_runmake 'man1dest=${D}${mandir}/man1' \
               'bindest=${D}${bindir}' \
               install
}

NATIVE_INSTALL_WORKS = "1"
BBCLASSEXTEND += "native nativesdk"

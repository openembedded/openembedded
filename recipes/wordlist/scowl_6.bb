DESCRIPTION = "SCOWL (Spell Checker Oriented Word Lists) is a collection of word lists split up in various sizes, and other categories, intended to be suitable for use in spell checkers. However, I am sure it will have numerous other uses as well."
HOMEPAGE = "http://wordlist.sourceforge.net/"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/wordlist/scowl-6.tar.gz \
           file://rules"

S = "${WORKDIR}/${PN}-${PV}"

do_compile() {
    cp -f ${WORKDIR}/rules ${S}
    oe_runmake -f rules build
}
do_install() {
    install -d ${D}/${datadir}/dict
    install ${S}/american-english ${D}/${datadir}/dict
    install ${S}/british-english ${D}/${datadir}/dict
    install ${S}/canadian-english ${D}/${datadir}/dict
}

PACKAGE_ARCH = "all"
PACKAGES = "wamerican wbritish wcanadian"

FILES = "${datadir}/dict/${DICTNAME}"

pkg_postinst() {
#!/bin/sh
if [ "x$D" != "x" ]; then
    exit 1
fi
cd ${datadir}/dict
ln -sf ${DICTNAME} words
}

DICTNAME_wamerican = "american-english"
DICTNAME_wbritish = "british-english"
DICTNAME_wcanadian = "canadian-english"

SRC_URI[md5sum] = "69d9b4b34dc85011d89115fa3cd2e011"
SRC_URI[sha256sum] = "2468f134a2a384eec8d154c7f8bdb9212c2601036aeec29bb38fdeaad3b14912"

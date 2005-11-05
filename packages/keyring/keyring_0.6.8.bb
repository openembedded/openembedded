DESCRIPTION = "Stores accounts and passwords in an encrypted file."
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Robert Anderson <rea@sr.unh.edu>"
LICENSE = "GPL"
DEPENDS = "gdbm"
PR = "r2"

SRC_URI = "http://www.scrypt.net/~celer/kweb/Keyring-0.6.8.tgz"
S = "${WORKDIR}/Keyring"

inherit palmtop

QPEDIR = "${OPIEDIR}"

do_install() {
        install -d ${D}${palmtopdir}/bin \
        	   ${D}${palmtopdir}/apps/Applications \
        	   ${D}${palmtopdir}/pics/keyring 
        install -m 0755 keyring ${D}${palmtopdir}/bin/
        install -m 0644 keyring.desktop \
			${D}${palmtopdir}/apps/Applications/
        install -m 0644 ${S}/Keyring.png \
			${S}/keyring-pwlist.png \
			${D}${palmtopdir}/pics/

	# The following should appear in an assoicated DOC package.

	install -d ${D}${palmtopdir}/help/html
        install -m 0644 ${S}/*.html ${D}${palmtopdir}/help/html/
}

PACKAGES = "${PN} ${PN}-help"
FILES_${PN} = " ${palmtopdir}${base_bindir} ${palmtopdir}/apps ${palmtopdir}/pics"
FILES_${PN}-help = " ${palmtopdir}/help/html"


DESCRIPTION = "Mofi"
SECTION = "openmoko/settings"
RDEPENDS = "python-core python-misc python-lang python-subprocess python-threading python-pygtk python-pygobject wpa-supplicant python-wifi"
PV = "0.02"
PR = "r1"
SRC_URI = "http://projects.openmoko.org/frs/download.php/271/mofi.${PV}.tar.gz \
	   file://setup.py \
           file://mofipath.patch;patch=0 \
	   file://mofi.desktop"
S = "${WORKDIR}/${PN}.${PV}"

inherit distutils 

do_configure_prepend() {
        mv ../setup.py .
}

do_install_append() {
	install -d ${D}${sysconfdir}/mofi
	install -d ${D}/${datadir}/applications
	install -m 0644 ${S}/example.mofi.conf ${D}${sysconfdir}/mofi/
	install -m 0755 ${S}/connect.sh ${D}${sysconfdir}/mofi/
        install -m 0644 ../mofi.desktop ${D}/${datadir}/applications
}

FILES_${PN} += "\
  ${sysconfdir}/mofi/example.mofi.conf \
  ${sysconfdir}/mofi/connect.sh \
  ${datadir}/applications/mofi.desktop"


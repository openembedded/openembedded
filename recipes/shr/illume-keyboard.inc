SECTION = "x11/data"

SRC_URI = "git://git.shr-project.org/repo/illume-keyboards.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

FILES_${PN} = "${libdir}/enlightenment/modules/illume/keyboards/*"
PACKAGE_ARCH = "all"

do_install() {
	install -d ${D}${libdir}/enlightenment/modules/illume/keyboards
	for f in ${INSTFILES}; do
		install -m 0644 ${S}/${BASEDIR}/${f} ${D}${libdir}/enlightenment/modules/illume/keyboards/
	done
}

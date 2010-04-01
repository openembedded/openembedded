DESCRIPTION = "The illume default keyboards"
SECTION = "x11/data"
SRCNAME = "e/src/modules/illume/keyboards"
PV = "0.16.999.060+svnr${SRCPV}"
PR = "r1"
SRCREV = "${EFL_SRCREV}"

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk;module=${SRCNAME};proto=http"
S = "${WORKDIR}/${SRCNAME}"

PACKAGE_ARCH = "all"

INSTPATH = "/enlightenment/modules/illume/keyboards"
INSTFILES = "\
Default.kbd \
alpha.png \
Numbers.kbd \
numeric.png \
Terminal.kbd \
qwerty.png \
"

PACKAGES = "${PN}-alpha ${PN}-numeric ${PN}-terminal"

FILES_${PN}-alpha = "\
  ${libdir}${INSTPATH}/Default.kbd \
  ${libdir}${INSTPATH}/alpha.png \
"
FILES_${PN}-numeric = "\
  ${libdir}${INSTPATH}/Numbers.kbd \
  ${libdir}${INSTPATH}/numeric.png \
"
FILES_${PN}-terminal = "\
  ${libdir}${INSTPATH}/Terminal.kbd \
  ${libdir}${INSTPATH}/qwerty.png \
"

do_install() {
	install -d ${D}${libdir}${INSTPATH}
	for f in ${INSTFILES}; do
		install -m 0644 ${S}/${f} ${D}${libdir}${INSTPATH}
	done
}


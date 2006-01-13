include libmatchbox.inc

#Remove the dash below when 1.7 changes in PV
PV = "1.7+cvs-${SRCDATE}"
DEFAULT_PREFERENCE = "-1"

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=${PN};proto=http\
	   file://check.m4"
S = "${WORKDIR}/libmatchbox"

do_configure_prepend () {
        mv ${WORKDIR}/check.m4 ${S}/
}

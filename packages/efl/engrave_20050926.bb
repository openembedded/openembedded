DESCRIPTION = "Engrave is an Edje Editing Library"
LICENSE = "MIT"
# also requires yacc and lex on host
DEPENDS = "virtual/evas virtual/ecore"

inherit efl

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/libs/engrave"
S = "${WORKDIR}/engrave"

do_stage_append() {
	for i in src/lib/engrave*.h
	do
		install -m 0644 $i ${STAGING_INCDIR}
	done
}


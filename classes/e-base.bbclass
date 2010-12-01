HOMEPAGE = "http://www.enlightenment.org"
SRCNAME ?= "${BPN}"

EFL_SRCREV ?= "55157"
SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk;module=${SRCNAME};proto=http"
S = "${WORKDIR}/${SRCNAME}"

ARM_INSTRUCTION_SET = "arm"

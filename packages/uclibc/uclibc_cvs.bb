PV = "0.0cvs${CVSDATE}"
PR = "r10"

include uclibc.inc

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/uclibc-cvs', '${FILE_DIRNAME}/uclibc', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"

SRC_URI += "cvs://anonymous:@uclibc.org/var/cvs;module=uClibc \
           file://nokernelheadercheck.patch;patch=1"
S = "${WORKDIR}/uClibc"

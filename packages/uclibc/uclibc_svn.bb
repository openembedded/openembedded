PV = "0.9.27+svn${CVSDATE}"

include uclibc.inc

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/uclibc-cvs', '${FILE_DIRNAME}/uclibc', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"

SRC_URI += "svn://uclibc.org/trunk;module=uClibc \
           file://nokernelheadercheck.patch;patch=1"
S = "${WORKDIR}/uClibc"

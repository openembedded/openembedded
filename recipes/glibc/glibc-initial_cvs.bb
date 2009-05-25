require glibc_${PV}.bb
require glibc-initial.inc

# glibc_cvs.bb overrides PV; glibc-cvs won't automatically be in FILESPATHPKG
FILESPATHPKG =. "glibc-cvs:"

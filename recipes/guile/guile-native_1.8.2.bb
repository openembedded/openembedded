SECTION = "unknown"
LICENSE = "GPL"
DEPENDS = "gmp-native libtool (< 2)"
SRC_URI = "http://ftp.gnu.org/pub/gnu/guile/guile-${PV}.tar.gz"
         
PR = "r1"

inherit autotools native

S="${WORKDIR}/guile-${PV}"


EXTRA_OECONF += "--enable-error-on-warning=no"

OE_LT_RPATH_ALLOW = "any"
LDFLAGS += " -L${STAGING_LIBDIR} "

do_configure() {
	# no autoreconf, thanks
	oe_runconf
}

LIBGUILE_HEADERS = "\
__scm.h \
alist.h \
arbiters.h \
async.h \
backtrace.h \
boolean.h \
chars.h \
continuations.h \
debug-malloc.h \
debug.h \
deprecation.h \
dynl.h \
dynwind.h \
environments.h \
eq.h \
error.h \
eval.h \
evalext.h \
extensions.h \
feature.h \
filesys.h \
fluids.h \
fports.h \
gc.h \
gdb_interface.h \
gdbint.h \
goops.h \
gsubr.h \
guardians.h \
hash.h \
hashtab.h \
hooks.h \
init.h \
ioext.h \
iselect.h \
keywords.h \
lang.h \
list.h \
load.h \
macros.h \
mallocs.h \
modules.h \
net_db.h \
numbers.h \
objects.h \
objprop.h \
options.h \
pairs.h \
ports.h \
posix.h \
print.h \
procprop.h \
procs.h \
properties.h \
ramap.h \
random.h \
rdelim.h \
read.h \
regex-posix.h \
root.h \
rw.h \
scmconfig.h \
scmsigs.h \
script.h \
simpos.h \
smob.h \
snarf.h \
socket.h \
sort.h \
srcprop.h \
stackchk.h \
stacks.h \
stime.h \
strings.h \
strorder.h \
strports.h \
struct.h \
symbols.h \
tags.h \
threads.h \
throw.h \
unif.h \
validate.h \
values.h \
variable.h \
vectors.h \
version.h \
vports.h \
weaks.h \
"

do_stage() {
	install -d ${STAGING_INCDIR}/libguile
	for i in ${LIBGUILE_HEADERS}; do
		install -m 0644 libguile/$i ${STAGING_INCDIR}/libguile/$i
	done

        install -d ${STAGING_BINDIR_NATIVE}
	install -m 0755 ${S}/libguile/.libs/guile ${STAGING_BINDIR_NATIVE}/

	install -m 0644 libguile.h ${STAGING_INCDIR}/libguile.h
	install -d ${STAGING_INCDIR}/guile
	install -m 0644 libguile/gh.h ${STAGING_INCDIR}/guile/
	install -d ${STAGING_INCDIR}/guile/srfi
	install -d ${STAGING_INCDIR}/guile-readline
	install -m 0644 guile-readline/readline.h ${STAGING_INCDIR}/guile-readline/
	install -d ${STAGING_DATADIR}/aclocal
	install -m 0644 guile-config/guile.m4 ${STAGING_DATADIR}/aclocal
	
	install -d ${STAGING_DATADIR}/guile/1.8
        cp -pPr  ${S}/ice-9 ${STAGING_DATADIR}/guile/1.8/
	
	oe_libinstall -C guile-readline -so -a libguilereadline-v-17 ${STAGING_LIBDIR}
	oe_libinstall -C libguile -so -a libguile ${STAGING_LIBDIR}
}

SRC_URI[md5sum] = "a4b64a992deae0532f8015bcc6c40784"
SRC_URI[sha256sum] = "1f7667c30228737e3cea58ff2b384bcc0eed8cb679392de827821e4d540c760e"

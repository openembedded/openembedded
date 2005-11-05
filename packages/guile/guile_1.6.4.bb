SECTION = "unknown"
LICENSE = "GPL"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
SRC_URI = "http://ftp.gnu.org/pub/gnu/guile/guile-${PV}.tar.gz \
	   file://configure-lossage.patch;patch=1"
DEPENDS = "guile-native"

inherit autotools

acpaths = "-I ${S}/guile-config"

do_compile() {
	(cd libguile; oe_runmake CC="${BUILD_CC}" CFLAGS="${BUILD_CFLAGS}" LDFLAGS="${BUILD_LDFLAGS}" guile_filter_doc_snarfage)
	oe_runmake preinstguile="`which guile`"
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
coop-defs.h \
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
strop.h \
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
	install -m 0644 libguile.h ${STAGING_INCDIR}/libguile.h
	install -d ${STAGING_INCDIR}/guile
	install -m 0644 libguile/gh.h ${STAGING_INCDIR}/guile/
	install -d ${STAGING_INCDIR}/guile/srfi
	install -d ${STAGING_INCDIR}/guile-readline
	install -m 0644 guile-readline/readline.h ${STAGING_INCDIR}/guile-readline/
	install -d ${STAGING_DATADIR}/aclocal
	install -m 0644 guile-config/guile.m4 ${STAGING_DATADIR}/aclocal
	oe_libinstall -C libguile -so -a libguile ${STAGING_LIBDIR}
	oe_libinstall -C guile-readline -so -a libguilereadline-v-12 ${STAGING_LIBDIR}
	oe_libinstall -C libguile-ltdl -so -a libguile-ltdl ${STAGING_LIBDIR}
}

#
# cpan-base providers various perl related information needed for building
# cpan modules
#
FILES_${PN} += "${libdir}/perl5 ${datadir}/perl5"

DEPENDS  += "${@["perl", "perl-native"][(bb.data.inherits_class('native', d))]}"
RDEPENDS  += "${@["perl", ""][(bb.data.inherits_class('native', d))]}"

# Determine the staged version of perl from the perl configuration file
def get_perl_version(d):
	import re
    	cfg = bb.data.expand('${STAGING_LIBDIR}/perl/config.sh', d)
	try:
		f = open(cfg, 'r')
	except IOError:
		return None
	l = f.readlines();
	f.close();
	r = re.compile("version='(\d+\.\d+\.\d+)'")
	for s in l:
		m = r.match(s)
		if m:
			return m.group(1)
	return None

# Determine where the library directories are
def perl_get_libdirs(d):
	libdir = bb.data.getVar('libdir', d, 1)
	libdirs = libdir + '/perl5'
	return libdirs

def is_target(d):
    if not bb.data.inherits_class('native', d):
        return "yes"
    return "no"

def perl_get_version_suffix(d):
	if bb.data.expand('${PACKAGE_ARCH}', d) != "all":
		return '-' + get_perl_version(d)
	else:
		return ''

PR .= "${@perl_get_version_suffix(d)}"

PERLLIBDIRS = "${@perl_get_libdirs(d)}"

FILES_${PN}-dbg += "${PERLLIBDIRS}/auto/*/.debug \
                    ${PERLLIBDIRS}/auto/*/*/.debug \
                    ${PERLLIBDIRS}/auto/*/*/*/.debug"

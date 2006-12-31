SECTION = "unknown"
require libpcre_${PV}.bb
inherit native
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libpcre-${PV}"

# NOTE: multiple providers are available (libpcre, libpcre-native);
# NOTE: consider defining PREFERRED_PROVIDER_pcre
PROVIDES = ""

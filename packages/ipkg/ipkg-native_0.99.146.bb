SECTION = "base"
include ipkg_${PV}.bb

# NOTE: ipkg now obeys ${libdir}, so ipkg-native now installs
# things into the wrong location inside of offline_root.  Backup
# the target libdir and use that.
target_libdir := "${libdir}"
DEFAULT_PREFERENCE=-1

inherit native

EXTRA_OECONF += "--with-ipkgdir=${target_libdir}/ipkg"

DEPENDS = "libtool-native automake-native"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/ipkg-${PV}"
PROVIDES = ""

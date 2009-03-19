require vala_${PV}.bb

inherit native
DEPENDS = "glib-2.0-native"

# work around timestamp problem in tarball
do_compile_prepend() {
	touch gobject/gobject.vala.stamp
}
    

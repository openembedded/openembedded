cml1_do_configure() {
	set -e
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake oldconfig
}

do_menuconfig() {
	export termwindowtitle="${pn} kernel configuration"
	export shellcmds="make menuconfig"
	${termcmdrun}
	if [ $? -ne 0 ]; then
		echo "fatal: '${termcmd}' not found. check termcmd variable."
		exit 1
	fi
}

do_menuconfig[nostamp] = "1"
addtask menuconfig after do_configure
EXPORT_FUNCTIONS do_configure
addtask configure after do_unpack do_patch before do_compile

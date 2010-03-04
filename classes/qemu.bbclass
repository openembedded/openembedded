#
# This class contains functions for recipes that need QEMU or test for its
# existance.
#

def check_gcc3(data):
	# Used by qemu to make sure we have a workable gcc-3.x.
	# Start by checking for the program name as we build it as there
	# are some distribtuion provided gcc-3.x's that will not work.
	gcc3_versions = 'gcc-3.4.6 gcc-3.4.4 gcc34 gcc-3.4 gcc-3.4.7 gcc-3.3 gcc33 gcc-3.3.6 gcc-3.2 gcc32'

	for gcc3 in gcc3_versions.split():
		if check_app_exists(gcc3, data):
			return gcc3

	return False

def qemu_target_binary(data):
	import bb

	target_arch = bb.data.getVar("TARGET_ARCH", data, 1)
	if target_arch in ("i486", "i586", "i686"):
		target_arch = "i386"
	elif target_arch == "powerpc":
		target_arch = "ppc"

	return "qemu-" + target_arch

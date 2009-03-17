def define_os (d):
	import bb
	if bb.data.getVar('TARGET_OS', d, 1).startswith('linux'):
		return "-DLINUX"
	return ""

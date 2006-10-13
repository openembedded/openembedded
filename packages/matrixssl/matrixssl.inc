def define_os (d):
	import bb
	if bb.data.getVar('TARGET_OS', d).startswith('linux'):
		return "-DLINUX"
	return ""

def get_kernelmajorversion(p):
	import re
	r = re.compile("([0-9]+\.[0-9]+).*")
	m = r.match(p);
	if m:
		return m.group(1)
	return None

def linux_module_packages(s, d):
	import bb
	if (bb.data.getVar("PARALLEL_INSTALL_MODULES", d, 1) == "1"):
		suffix = "-%s" % (get_kernelmajorversion(base_read_file(bb.data.expand('${STAGING_KERNEL_DIR}/kernel-abiversion', d))))
	else:
		suffix = ""
	return " ".join(map(lambda s: "kernel-module-%s%s" % (s.lower().replace('_', '-').replace('@', '+'), suffix), s.split()))

# that's all


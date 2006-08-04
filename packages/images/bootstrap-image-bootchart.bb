# 
# old_revision [bbd3a2811e13a3b99224c1a846af2a244d292c41]
# 
# add_file "packages/images/bootstrap-image-bootchart.bb"
#  content [c85210cae1668b832e717ed0f45cba34e24fd811]
# 
============================================================
--- packages/images/bootstrap-image-bootchart.bb	c85210cae1668b832e717ed0f45cba34e24fd811
+++ packages/images/bootstrap-image-bootchart.bb	c85210cae1668b832e717ed0f45cba34e24fd811
@@ -0,0 +1,10 @@
+export IMAGE_BASENAME = "bootstrap-image-bootchart"
+export IMAGE_LINGUAS = ""
+export IPKG_INSTALL = "task-bootstrap bootchart acct"
+
+DEPENDS = "task-bootstrap bootchart"
+RDEPENDS = "acct"
+
+inherit image_ipk
+
+LICENSE = MIT

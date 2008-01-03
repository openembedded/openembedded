#! /bin/sh
# MIT Licensed
# Initial version by Graeme 'XorA' Gregory, Further changes by Koen Kooi

# Run this from inside ${DEPLOY_DIR} e.g. tmp/deploy/glibc/

# Angstrom webserver
REMOTEM=angstrom@linuxtogo.org

# Feed dir we want to upload to
REMOTED=website/feeds/2007/ipk/glibc

# create upload dir
mkdir -p upload-queue || true

# Find and delete morgue dirs, we don't need them
find ipk/ -name "morgue" -exec rm -rf \{\} \;

# Copy all packages to an upload queue
find ipk/ -name "*.ipk" -exec cp \{\} upload-queue/ \;

# Find file already present on webserver
ssh $REMOTEM "find $REMOTED/ -name "*.ipk" -exec basename \{\} \;" > /tmp/files-remote
ls upload-queue/ | grep -v morgue >/tmp/files-local

# Check for files already present on webserver
cat /tmp/files-remote /tmp/files-local | sort | uniq -u >/tmp/files-uniq
cat /tmp/files-uniq /tmp/files-local | sort | uniq -d > /tmp/files-trans

# Copy over non-duplicate files
rsync -vz --files-from=/tmp/files-trans upload-queue/ $REMOTEM:$REMOTED/unsorted/

# Clean up temporary files
rm /tmp/files-remote /tmp/files-local /tmp/files-uniq /tmp/files-trans


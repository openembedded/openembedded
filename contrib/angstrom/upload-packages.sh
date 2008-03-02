#! /bin/sh
# MIT Licensed
# Initial version by Graeme 'XorA' Gregory, Further changes by Koen Kooi

# Run this from inside ${DEPLOY_DIR} e.g. tmp/deploy/glibc/

# Angstrom webserver
REMOTEM=angstrom@linuxtogo.org

# Feed dir we want to upload to
REMOTED=website/feeds/2008/ipk/$(basename $PWD)

# create upload dir
mkdir -p upload-queue || true

# Find and delete morgue dirs, we don't need them
find ipk/ -name "morgue" -exec rm -rf \{\} \;

# Copy all packages to an upload queue
find ipk/ -name "*.ipk" -exec cp \{\} upload-queue/ \;

# Find file already present on webserver
ssh $REMOTEM "find $REMOTED/ -name "*.ipk" -exec basename \{\} \;" > files-remote
ls upload-queue/ | grep -v morgue > files-local

# Check for files already present on webserver
cat files-remote files-local | sort | uniq -u >files-uniq
cat files-uniq files-local | sort | uniq -d > files-trans

# Copy over non-duplicate files
rsync -vz --files-from=files-trans upload-queue/ $REMOTEM:$REMOTED/unsorted/

# Clean up temporary files
rm -rf files-remote files-local files-uniq files-trans upload-queue	


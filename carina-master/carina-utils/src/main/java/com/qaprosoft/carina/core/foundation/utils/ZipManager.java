/*******************************************************************************
 * Copyright 2013-2020 QaProSoft (http://www.qaprosoft.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.qaprosoft.carina.core.foundation.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.invoke.MethodHandles;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZipManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    

    @SuppressWarnings("rawtypes")
    public static void unzip(String zip, String extractTo) {
        Enumeration entries;
        ZipFile zipFile = null;

        try {
            zipFile = new ZipFile(zip);

            entries = zipFile.entries();

            while (entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) entries.nextElement();

                if (entry.isDirectory()) {
                    File folder = new File(extractTo + "/" + entry.getName());
                    boolean isCreated = folder.mkdir();
                    if (!isCreated) {
                        throw new RuntimeException("Folder not created: " + folder.getAbsolutePath());
                    }
                    continue;
                }

                InputStream is = zipFile.getInputStream(entry);
                try {
                    FileOutputStream fos = new FileOutputStream(extractTo + "/" + entry.getName());
                    try {
                        BufferedOutputStream bos = new BufferedOutputStream(fos);
                        try {
                            copyInputStream(is, bos);
                        } finally {
							bos.close();
                        }
                    } finally {
						fos.close();
                    }
                } finally {
                    if (is != null) {
                        is.close();
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.error("Error during unzip!", e);
        } finally {
            try {
                if (zipFile != null) {
                    zipFile.close();
                }
            } catch (IOException e) {
                LOGGER.error("Error during closing zipFile!", e);
            }
        }
    }

    public static final void copyInputStream(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int len;

        if (in == null) {
        	return;
        }
        
        while ((len = in.read(buffer)) >= 0)
            out.write(buffer, 0, len);

        in.close();
        out.close();
    }
}

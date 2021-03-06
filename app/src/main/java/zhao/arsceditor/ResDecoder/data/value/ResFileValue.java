/**
 *  Copyright 2014 Ryszard Wiśniewski <brut.alll@gmail.com>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package zhao.arsceditor.ResDecoder.data.value;

import java.io.IOException;

import zhao.arsceditor.ResDecoder.ARSCCallBack;
import zhao.arsceditor.ResDecoder.GetResValues;
import zhao.arsceditor.ResDecoder.data.ResResource;

/**
 * @author Ryszard Wiśniewski <brut.alll@gmail.com>
 */
public class ResFileValue extends ResIntBasedValue implements GetResValues {
	private final String mPath;

	public ResFileValue(String path, int rawIntValue) {
		super(rawIntValue);
		this.mPath = path;
	}

	public String getPath() {
		return mPath;
	}

	@Override
	public void getResValues(ARSCCallBack back, ResResource res) throws IOException {
		back.back(res, res.getConfig().toString(), res.getResSpec().getType().getName(),
				res.getResSpec().getName(), getStrippedPath());
	}

	public String getStrippedPath() throws IOException {
		if (!mPath.startsWith("res/") && !mPath.startsWith("r/") && !mPath.startsWith("R/")) {
			throw new IOException("File path does not start with \"res/\" or \"r/\": " + mPath);
		}
		return mPath;/* .substring(4); */
	}

	@Override
	public String toString() {
		return mPath;
	}
}

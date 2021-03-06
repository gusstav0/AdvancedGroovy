/* ===================================================
 * Copyright 2012 Kousen IT, Inc.
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
 * ========================================================== */
package groovy.ast.delegate

class Phone {
    String dial(String number) { "dialing $number" }
    String getManufacturer() { "Samsung" }
}

class Camera {
    String takePicture() { "taking picture" }
    String getManufacturer() { "Nikon" }
}

class SmartPhone {
    @Delegate Phone phone = new Phone()
    @Delegate Camera camera = new Camera()

    String getManufacturer() {
      "${phone.manufacturer}, ${camera.manufacturer}" }
}

SmartPhone sp = new SmartPhone()
assert sp.dial('555-1234') == 'dialing 555-1234'
assert sp.takePicture() == 'taking picture'
println sp.manufacturer
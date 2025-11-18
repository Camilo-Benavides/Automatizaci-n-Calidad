FROM eclipse-temurin:21-jdk-jammy

# Instalar dependencias necesarias incluyendo Chrome y Gradle
RUN apt-get -y update && export DEBIAN_FRONTEND=noninteractive \
    && apt-get -y install --no-install-recommends \
    git \
    sudo \
    curl \
    wget \
    unzip \
    gnupg \
    # Dependencias para Chrome
    libnss3 \
    libgconf-2-4 \
    libfontconfig1 \
    libxss1 \
    libappindicator3-1 \
    libasound2 \
    libatk-bridge2.0-0 \
    libgtk-3-0 \
    libgbm1 \
    libvulkan1 \
    # Utilidades adicionales
    ca-certificates \
    fonts-liberation \
    xdg-utils \
    && apt-get clean -y && rm -rf /var/lib/apt/lists/*

# Instalar Git LFS
RUN curl -s https://packagecloud.io/install/repositories/github/git-lfs/script.deb.sh | bash \
    && apt-get install -y git-lfs \
    && apt-get clean -y && rm -rf /var/lib/apt/lists/*

# Instalar Google Chrome (estable)
RUN wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb \
    && apt-get -y update \
    && apt-get -y install --no-install-recommends ./google-chrome-stable_current_amd64.deb \
    && rm google-chrome-stable_current_amd64.deb \
    && apt-get clean -y && rm -rf /var/lib/apt/lists/*

# Gradle viene preinstalado con eclipse-temurin o lo instalamos
RUN wget https://services.gradle.org/distributions/gradle-8.5-bin.zip -P /tmp \
    && unzip -d /opt/gradle /tmp/gradle-8.5-bin.zip \
    && rm /tmp/gradle-8.5-bin.zip \
    && ln -s /opt/gradle/gradle-8.5/bin/gradle /usr/bin/gradle

ENV GRADLE_HOME=/opt/gradle/gradle-8.5
ENV PATH=$GRADLE_HOME/bin:$PATH
ENV JAVA_HOME=/opt/java/openjdk

# Configurar el repositorio de Docker
#RUN mkdir -p /etc/apt/keyrings \
#   && curl -fsSL https://download.docker.com/linux/ubuntu/gpg | gpg --dearmor -o /etc/apt/keyrings/docker.gpg \
#   && echo "deb [arch=amd64 signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu jammy stable" > /etc/apt/sources.list.d/docker.list \
#   && apt-get -y update

# Instalar Docker y sus componentes
#RUN apt-get install -y docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin \
#    && apt-get clean -y && rm -rf /var/lib/apt/lists/*

# Crear el usuario developer con permisos adecuados
RUN useradd -ms /bin/bash developer \
    && mkdir -p /workspace \
    && chown -R developer:developer /workspace \
    && usermod -aG sudo developer \
    && echo "developer ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers

# Configurar variables de entorno para Chrome headless
ENV CHROME_BIN=/usr/bin/google-chrome
ENV CHROME_FLAGS="--no-sandbox --disable-dev-shm-usage --disable-gpu"

# Establecer el usuario developer como predeterminado
USER developer

# Establecer el directorio de trabajo
WORKDIR /workspace